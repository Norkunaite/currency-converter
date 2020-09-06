import React from 'react';
import Main from './components/Main';


function App() {
  return (
    <div className="container-fluid">
      <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1 class="display-4">Currency Converter</h1>
          <p class="lead">Conversions made easy</p>
        </div>
      </div>
      <div className="container"><Main /></div>
    </div>
  );
}

export default App;
