package divelbmn.text_solver_environment.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import divelbmn.text_solver_environment.Environment.dto.SensorDto;
import divelbmn.text_solver_environment.Environment.dto.StateDto;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.util.Objects;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiEnvironmentControllerTest {

    private final String CONTROLLER_PATH = "/environment/doAction";

    private static final Float VALUE = 1f;
    private static final Float ZERO_VALUE = 0f;


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();


    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testGotoItemAction() throws Exception {

        String content = performRequestContent("ApiEnvironmentControllerTest/testGotoItemAction.json");

        MvcResult mvcResult = this.mockMvc
                .perform(post(CONTROLLER_PATH)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content))
                .andExpect(status().isOk())
                .andReturn();

        StateDto result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), StateDto.class);

        assertTrue(result.hasSensor(new SensorDto("nearItem", VALUE)));
        assertFalse(result.hasSensor(new SensorDto("nearOwner", VALUE)));
        assertFalse(result.hasSensor(new SensorDto("hasItem", VALUE)));
        assertFalse(result.hasSensor(new SensorDto("ownerHasItem", VALUE)));
    }

    @Test
    public void testGotoOwnerAction() throws Exception {

        String content = performRequestContent("ApiEnvironmentControllerTest/testGotoOwnerAction.json");

        MvcResult mvcResult = this.mockMvc
                .perform(post(CONTROLLER_PATH)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content))
                .andExpect(status().isOk())
                .andReturn();

        StateDto result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), StateDto.class);

        assertFalse(result.hasSensor(new SensorDto("nearItem", VALUE)));
        assertTrue(result.hasSensor(new SensorDto("nearOwner", VALUE)));
        assertFalse(result.hasSensor(new SensorDto("hasItem", VALUE)));
        assertFalse(result.hasSensor(new SensorDto("ownerHasItem", VALUE)));
    }

    @Test
    public void testPickupItemAction() throws Exception {

        String content = performRequestContent("ApiEnvironmentControllerTest/testPickupItemAction.json");

        MvcResult mvcResult = this.mockMvc
                .perform(post(CONTROLLER_PATH)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content))
                .andExpect(status().isOk())
                .andReturn();

        StateDto result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), StateDto.class);

        assertTrue(result.hasSensor(new SensorDto("nearItem", VALUE)));
        assertFalse(result.hasSensor(new SensorDto("nearOwner", VALUE)));
        assertTrue(result.hasSensor(new SensorDto("hasItem", VALUE)));
        assertFalse(result.hasSensor(new SensorDto("ownerHasItem", VALUE)));
    }

    @Test
    public void testGiveItemAction() throws Exception {

        String content = performRequestContent("ApiEnvironmentControllerTest/testGiveItemAction.json");

        MvcResult mvcResult = this.mockMvc
                .perform(post(CONTROLLER_PATH)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content))
                .andExpect(status().isOk())
                .andReturn();

        StateDto result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), StateDto.class);

        assertFalse(result.hasSensor(new SensorDto("nearItem", VALUE)));
        assertTrue(result.hasSensor(new SensorDto("nearOwner", VALUE)));
        assertTrue(result.hasSensor(new SensorDto("hasItem", ZERO_VALUE)));
        assertTrue(result.hasSensor(new SensorDto("ownerHasItem", VALUE)));
    }

    private String performRequestContent(String jsonFileName) throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader
                .getResource(jsonFileName))
                .getFile());

        return FileUtils.readFileToString(file, "UTF-8");
    }
}