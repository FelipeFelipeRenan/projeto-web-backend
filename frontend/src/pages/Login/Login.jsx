import React, { useState } from "react";

import "./Login.scss";
import Header from "../../components/Header/Header";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loggedIn, setLoggedIn] = useState(false);

  const handleLogin = () => {
    // Simples lógica de autenticação (substitua por lógica real)
    if (username === "usuario" && password === "senha") {
      setLoggedIn(true);
    } else {
      alert("Credenciais inválidas");
    }
  };

  return (
    <div className="App">
      <Header />
      {loggedIn ? (
        <div>
          <h2>Bem-vindo teste do actions, {username}!</h2>
          <button onClick={() => setLoggedIn(false)}>Sair</button>
        </div>
      ) : (
        <div>
          <h2>Faça login</h2>
          <form>
            <label>
              Usuário:
              <input
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </label>
            <br />
            <label>
              Senha:
              <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </label>
            <br />
            <button type="button" onClick={handleLogin}>
              Entrar
            </button>
          </form>
        </div>
      )}
    </div>
  );
};

export default Login;
