package br.com.acc.mensagens

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface MensagemRepository : CrudRepository<Mensagem, String> {

    @Query(value = "select id, text from mensagem", nativeQuery = true)
    fun findMessages(): List<Mensagem>
}