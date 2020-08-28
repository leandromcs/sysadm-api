# Sysadm API

Este projeto é uma API de gerenciamento de pessoas. Ele tem por objetivo servir como exemplo de API que tem conteúdo de básico como, por exemplo, CRUD de pessoa ao mais avançado como, por exemplo, login utilizando JWT.

O login foi feito utilizando a biblioteca do JWT pura, ou seja, sem Spring Security para melhor aprendizado do funcionamento do JWT.
Além disso, alguns endpoints não utilizam o DTO Pattern com objetivo de exemplificar como construir uma API sem utilização deste pattern que é amplamente utilizado.

Tecnologias utilizadas:
Spring boot, Spring MVC, Spring Data JPA, Bean Validation, JWT, MySQL

Explicação de funcionamento da API:
Na API, temos os Operadores que são os usuários de fato do sistema e eles que fazem o gerenciamento de pessoas. Cada operador tem o seu papel(GERENTE, ANALISTA ou ADMINISTRADOR) e cada endpoint pode necessitar que o operador tenha um papel específico para que a ação seja realizada.

