<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Detalhes do Browser</title>
</head>
<body>
  <h3>Detalhes do Browser</h3>
  <div>
    <strong>Nome</strong>: ${userAgent.name}
  </div>
  <div>
    <strong>Versão</strong>: ${userAgent.versionNumber.major}.${userAgent.versionNumber.minor}
  </div>
  <div>
    <strong>SO</strong>: ${userAgent.operatingSystem.name}
  </div>
</body>
</html>
