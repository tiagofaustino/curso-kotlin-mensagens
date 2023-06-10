package br.com.acc.mensagens

import org.springframework.stereotype.Service

@Service
class MensagemService(val db: MensagemRepository) {
    fun findMessages(): List<Mensagem> = db.findMessages()

    fun post(mensagem: Mensagem) {
        db.save(mensagem)
    }

    fun existsById(id: Long): Boolean {
        return db.existsById(id.toString())
    }

    fun put(message: Mensagem) {
        db.save(message)
    }

    fun delete(id: Long) {
        db.deleteById(id.toString())
    }
}