package pl.wojtyna.trainings.designpatterns.solutions.crowdsorcery.task2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class BorrowersRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void registerProblems() throws Exception {
        mockMvc.perform(post("/solutions/borrowers").contentType(MediaType.APPLICATION_JSON)
                                                    .content("{\"name\": \"John\", \"surname\": \"Doe\"}"))
               .andExpect(status().isOk());
        mockMvc.perform(post("/solutions/borrowers")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"name\": \"George\", \"surname\": \"Martin\"}"))
               .andExpect(status().isOk());
        mockMvc.perform(post("/solutions/borrowers")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"name\": \"Henry\", \"surname\": \"Holmes\"}"))
               .andExpect(status().isOk());

        mockMvc.perform(get("/solutions/borrowers"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.size()").value(3));
    }
}
