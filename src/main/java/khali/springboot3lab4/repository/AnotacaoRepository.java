package khali.springboot3lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import khali.springboot3lab4.entity.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long>{
    
}