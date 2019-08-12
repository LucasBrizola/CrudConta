# CrudConta

Efetuar o desenvolvimento de uma api REST em Java com o seguinte endpoint:
    Conta
        {
            id : String gerado automaticamente ao criar
            numero: String -> Somente digitos e no máximo 6 caracteres 
            agencia: String -> Somente digitos e no máximo 4 caracteres
            cpf: String -> Somente digitos e no máximo 11 caracteres
            status: Boolean -> Default ativo
            dataCriacao -> LocalDate
            dataAtualizacao -> LocalDate
        }
        GET /conta
            Lista todas contas cadastradas -> Possivel paginar
        GET /conta/{id}
            Retorna uma conta especifica pelo ID
        POST /conta
            Salva uma conta na base de dados
        PUT /conta/{id}
            Atualiza um conta
        DELETE /conta/{id}
            Faz o delete lógico da conta (status = false)


testes de controller via postmen:

POST: localhost:8080/banco/conta/
exemplo Json:
{
	"numero":"35101",
	"agencia":"0200",
	"cpf":"03054587010",
	"dataCriacao":"2016-10-10",
	"dataAtualizacao":"2018-12-10"
}

GET(all): localhost:8080/banco/conta/

GET(id): localhost:8080/banco/conta/(id)

PUT: localhost:8080/banco/conta/(id)
exemplo json:
{
	"numero":"35101",
	"agencia":"0200",
	"cpf":"03054587010",
	"dataCriacao":"2016-10-10",
	"dataAtualizacao":"2019-10-10"
}

DELETE: localhost:8080/banco/conta/(id)
