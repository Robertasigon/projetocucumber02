#language: pt
#encoding: iso-8859-1

Funcionalidade: Acessar Conta
como um usuario cadastrado no sistema
eu quero acessar minha conta de usuário
para que eu possa gernciar meus dasos

Cenário: Autenticação de usuário com sucesso
Dado Acessar a página de autenticação de usuário
E Informar o email do usuário "testador@gmail.com"
E Informar a senha do usuário "@Teste2022"
Quando Solicitar a realização do acesso
Então Sistema autentica o usuário com sucesso

Cenário: Acesso Negado
Dado Acessar a página de autenticação de usuário
E Informar o email do usuário "teste@gmail.com"
E Informar a senha do usuário "@Aula2022"
Quando Solicitar a realização do acesso
Então Sistema imforma que o acesso é negado