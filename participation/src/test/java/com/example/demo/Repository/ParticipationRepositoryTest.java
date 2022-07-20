package com.example.demo.Repository;

import com.example.demo.Model.Participation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
@DataJpaTest
class ParticipationRepositoryTest {

    @MockBean
    ParticipationRepository participationRepository;


    @Test
    void findByStatus() {

        List<Participation> p=new ArrayList<>();
        p.add(new Participation(1,1,"ridhi",1,"abc",4,"football","pending"));
        when(participationRepository.findByStatus("pending")).thenReturn(p);
        assertEquals(p,participationRepository.findByStatus("pending"));

    }
}