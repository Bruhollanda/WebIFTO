<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Prova</title>
  <style>
    label {
      display: block;
    }

    fieldset {
      margin: 2em 1em;
    }
  </style>
</head>
<body>
  <h1>Prova</h1>

  <form action="prova" method="post">
    <label>Aluno <input type="text" placeholder="Infome seu nome" name="nome"></label>
    <br><br>
    <fieldset>
      <legend>01) Quais dos seguintes animais são mamíferos</legend>
      <select size="8" multiple>
        <option name="animal" value="errada">Tubarão</option>
        <option name="animal" value="certa">Golfinho</option>
        <option name="animal" value="errada">Tartaruga</option>
        <option name="animal" value="certa">Onça</option>
        <option name="animal" value="errada">Sapo</option>
        <option name="animal" value="errada">Largato</option>
        <option name="animal" value="certa">Mico Leão</option>
        <option name="animal" value="errada">Garça</option>
      </select>
    </fieldset>
    <fieldset>
      <legend>02) Selecione todos os itens que sejam software</legend>
      <label><input type="checkbox" name="software" value="certa">Sistema Operacional</label>
      <label><input type="checkbox" name="software" value="errada">Memôria RAM</label>
      <label><input type="checkbox" name="software" value="errada">GPU</label>
      <label><input type="checkbox" name="software" value="certa">Planilha Eletrônica</label>
      <label><input type="checkbox" name="software" value="certa">Compilador</label>
    </fieldset>
    <fieldset>
      <legend>03) Em qual data iniciou a Primeira Guerra Mundial</legend>
      <input type="date" name="date">
    </fieldset>
    <fieldset>
      <legend>04) Qual dos seguintes metais é liquido em temperatura ambiente</legend>
      <label><input type="radio" name="metal" value="cobre">Cobre</label>
      <label><input type="radio" name="metal" value="ferro">Ferro</label>
      <label><input type="radio" name="metal" value="mercurio">Mercúrio</label>
      <label><input type="radio" name="metal" value="ouro">Ouro</label>
    </fieldset>
    <fieldset>
      <legend>05) Qual o resultado da seguinte expressão: 2+4*5-3</legend>
      <input type="number" name="resultado">
    </fieldset>

    <input type="submit" value="Enviar">
  </form>
</body>
</html>