import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import NavBar from './components/NavBar/NavBar';
import Footer from './components/Footer/Footer';
import Home from './components/Home/Home';

function App() {
  return (
    <Router>
      <div>
        <NavBar />
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/categorias" exact component={CategoriaList} />
          <Route path="/categorias/nova" exact component={CategoriaForm} />
        </Switch>
        <Footer />
      </div>
    </Router>
  );
}

export default App;
