# Pads

Fiz ajustes finos em:

- [ ] `com.projetos.springpad.controller.owner.LoginController.java`

## Listando todos os Pads na Home

Vamos exibir todos os pads válidos na página inicial (`home.html`) com os seguintes requisitos:

- Somente com `Status.ON`
- Ordenados por `createdAt` mais recentes
- Lista somente os campos `pads.id`, `pads.title`, `pads.content`, `owners.id`, `owners.displayName`, `owners.photoURL`

No caso do campo de `pads.content`, faremos ajustes para exibir somente os 30 primeiros caracteres, na forma de um resumo que é obtido do _pseudo campo_ `pads.contentSummary`.

Vamos criar a entidade `pads`:

 - [ ] Crie `com.projetos.springpad.model.PadsModel.java`
 - [ ] Crie `com.projetos.springpad.repository.PadsRepository.java`
 - [ ] Crie `com.projetos.springpad.dto.PadSummaryDTO.java`

`PadsRepository.java` já tem o método `findSummariesByStatusOrderByCreatedAtDesc()` que obtém os dados necessários usando a **_JPQL_** (_Java Persistence Query Language_).

`PadSummaryDTO.java` lista os campos que serão obtidos das tabelas `pads` e `owners`, incluindo o _pseudo campo_ `pads.contentSummary` que contém o resumo de `pads.content`.

Para alterar a quantidade de caracteres no resumo, altere o valor "30" na linha `SUBSTRING(p.content, 1, 30)` de `PadsRepository.java`. 

Esse script SQL cadastra 10 "pads" fake para os testes iniciais. Rode-o no **H2 Console**, na tabela `pads`:

 - [ ] Crie `fakepads.sql`

Ajuste o template da página inicial para listar os "pads":

 - [ ] Edite `src/main/resources/templates/home.html`

## Detalhes de um pad

Ao clicar no título de um "pad" na "home", acessa a rota `/view/{pad.id}` que exibe detalhes do registro clicado.
Também exibe botões `[Editar]` e `[Apagar]` se o "pad" pertence ao usuário logado.

Para implementar, insira ou ajuste as partes:

 - [ ] Crie `com.projetos.springpad.controller.pad.ViewController.java`
 - [ ] Edite `com.projetos.springpad.repository.PadsRepository.java`
 - [ ] Crie `src/main/resources/templates/pad/view.html`

No `PadsRepository.java`, adicionamos o método `findByIdWithOwner()` para obter os dados do "pad" e o respectivo "owner".

Já em `view.html` os botões `[Editar]` e `[Apagar]` só aparecem para o proprietário do "pad" exibido.