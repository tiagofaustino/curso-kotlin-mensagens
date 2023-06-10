package br.com.acc.mensagens

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "mensagem")
data class Mensagem(
    @Id
    @GeneratedValue
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    val id: Int,
    val text: String
)