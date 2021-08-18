import React, { Component } from 'react';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import './App.css';
import Home from './components/pages/Home';
import Recipes from './components/pages/Recipes';
import Products from './components/pages/Products';
import SignUp from './components/pages/SignUp';

class App extends Component {
  render() {
    return (
      <div>
        <Router>
          <Navbar/>
          <Switch>
            <Route path="/" exact component={Home} />
            <Route path='/recipes' component={Recipes} />
            <Route path='/products' component={Products} />
            <Route path='/sign-up' component={SignUp} />
          </Switch>
        </Router>
      </div>
    )
  }
}



export default App;
