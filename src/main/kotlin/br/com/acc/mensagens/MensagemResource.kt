package br.com.acc.mensagens

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("messages")
class MensagemResource(val service: MensagemService) {
    @GetMapping
    fun index(): List<Mensagem> = service.findMessages()

    @PostMapping
    fun post(@RequestBody message: Mensagem) : ResponseEntity<String> {
        service.post(message)
        return ResponseEntity("inserido com sucesso", HttpStatus.OK)
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody message: Mensagem): ResponseEntity<String> {
        if(service.existsById(id)) {
            service.put(message)
            return ResponseEntity("atualizado com sucesso", HttpStatus.OK)
        }
        return ResponseEntity("não foi encontrado o id informado", HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<String> {
        if(service.existsById(id)) {
            service.delete(id)
            return ResponseEntity("removido com sucesso", HttpStatus.OK)
        }
        return ResponseEntity("não foi encontrado o id informado", HttpStatus.NOT_FOUND)
    }
}