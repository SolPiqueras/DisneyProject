package ar.solPiqueras.disney;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.solPiqueras.disney.data.entities.CategoryEntity;
import ar.solPiqueras.disney.data.repositories.CategoryRepository;
import ar.solPiqueras.disney.web.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoryRepository categoryRepository;

    @Autowired
    ObjectMapper objectMapper;

   

    @Test
    void createCategoryTest() throws Exception {
 

        CategoryEntity ceWithIdNull = buildEntity(null, "Marketing", "category of marketing");
        CategoryEntity ceWithId = buildEntity(1L, "Health", "category of health");

        when(categoryRepository.save(ceWithIdNull)).thenReturn(ceWithId);

        mockMvc.perform(post("/ong/categories").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(ceWithId)))
            .andExpect(status().isCreated())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("Health")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.description", is("category of health")));        
    }

    @Test
    void deleteCategoryTest() throws Exception {

        when(categoryRepository.existsById(5L)).thenReturn(true);
        when(categoryRepository.findById(5L)).thenReturn(Optional.of(buildEntity(5L, "RRHH", "category of RRHH")));

        mockMvc.perform(delete("/ong/categories/5")).andExpect(status().isNoContent()); 
    }

   
    @Test
    void deleteCategoryTestWrongId() throws Exception {

        Mockito.doThrow(ResourceNotFoundException.class).when(categoryRepository).deleteById(1L);

        mockMvc.perform(delete("/ong/categories/1")).andExpect(status().isNotFound());
    }

    @Test
    void listCategoriesTest() throws Exception {

        CategoryEntity categoryEntity = buildEntity(1L, "Marketing", "category of marketing");
        CategoryEntity categoryEntity2 = buildEntity(2L, "Health", "category of health" );
    
        List<CategoryEntity> ce = new ArrayList<>();
        ce.add(categoryEntity);
        ce.add(categoryEntity2);
        
        when(categoryRepository.findAll()).thenReturn(ce);

        mockMvc.perform(get("/ong/categories").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(categoryEntity)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Marketing")))
                .andExpect(jsonPath("$[1].name", is("Health")));
   
    }

    @Test
    void updateCategoryTest() throws Exception { 

        CategoryEntity categoryEntity = buildEntity(1L, "Marketing", "category of marketing");

        when(categoryRepository.save(categoryEntity)).thenReturn(categoryEntity);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(categoryEntity)); 
        
        CategoryEntity categoryEntity2 = buildEntity(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription());
        
        mockMvc.perform(put("/ong/categories/1").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(categoryEntity2)))
                .andExpect(status().isOk());

    }

    private CategoryEntity buildEntity(Long id, String name, String description) {

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(id);
        categoryEntity.setName(name);
        categoryEntity.setDescription(description);
        categoryEntity.setDeleted(false);
        return categoryEntity;
        
    }
    
}
