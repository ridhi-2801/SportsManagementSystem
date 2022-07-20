package com.example.demo.Repository;

import com.example.demo.Model.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation,Integer> {

    public List<Participation> findByStatus(String status);

}
