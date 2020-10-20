import React from 'react';
import logo from './logo.svg';
import './App.css';
import Apicon from './CamposCadastro.js';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p className="row justify-content-right">
          Api UI
        </p>
        <Apicon></Apicon>
        
      </header>
    </div>
  );
}


// App component

export default App;
