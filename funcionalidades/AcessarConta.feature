#language: pt
#encoding: iso-8859-1

Funcionalidade: Acessar Conta
como um usuario cadastrado no sistema
eu quero acessar minha conta de usu�rio
para que eu possa gernciar meus dasos

Cen�rio: Autentica��o de usu�rio com sucesso
Dado Acessar a p�gina de autentica��o de usu�rio
E Informar o email do usu�rio "testador@gmail.com"
E Informar a senha do usu�rio "@Teste2022"
Quando Solicitar a realiza��o do acesso
Ent�o Sistema autentica o usu�rio com sucesso

Cen�rio: Acesso Negado
Dado Acessar a p�gina de autentica��o de usu�rio
E Informar o email do usu�rio "teste@gmail.com"
E Informar a senha do usu�rio "@Aula2022"
Quando Solicitar a realiza��o do acesso
Ent�o Sistema imforma que o acesso � negado