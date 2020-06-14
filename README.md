# HTTPS Simulador

O exemplo que existe na main é o seguinte:

360235768BBEE00F1BE8E60DD55C2D6EA9A8AD1CE0BD546F7C8BB32942625C89888E5A54B432A1C15427FFF0B6E2473639DBEA7A6B9A240FB80591F108AA7F5F915BF229CE27E99A839126488BA403BBEBAB302478027647A84EBCBCE2FA9876

Essa foi uma mensagem enviada e encriptada com a chave gerada (iv + mensagem encriptada)

Caso deseje mudar a mensagem encriptada basta somente alterar o valor de messageEncrypted na Main.java.

O resultado exibido no console tem duas partes:

* primeira parte: recebe um	valor hexadecimal (valor B) e imprime A em hexadecimal (hex(g^a mod p)) e os 128 primeiros bits de S 
em hexadecimal (senha). No caso a função que gera um valor aleatório não está sendo executada e retorna um valor estático
que foi usado no processo de troca de chaves.

    A = g^a mod p

    hex(A) = 253ecd94cdc665c2cbfaa20146bd5db4b620a1d16558004c07cd34826a8cf99c6843eeaafbf8d0ca29f0e8d42461e646d4960a4c237226b913db88fa29b75a99e90898b1caf6134d6d1a2d5dfff40fc9bee9eb3d892f53922ae195c85fad7e42c40bab76fad13f628c526c3b810989d937bf9c986adaa5de5b20bb5590b5cd95

    password = 31B81508907459C82BE398B1FD6A632B

* segunda parte: recebe	a mensagem e a chave (128 primeiros	bits de	S em hexadecimal), e imprime a mensagem	recebida (em
texto claro) e a mensagem a	ser	enviada	(em	hexadecimal).

    A mensagem enviada embora seja a mesma sempre será diferente, pois, o iv é gerado de forma aleatória.
    
Paulo Aranha