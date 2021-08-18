import React, {Component} from 'react';
import './App.css';
import Home from './Home';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import UserList from "./UserList";
import UserEdit from "./UserEdit";
import Login from "./containers/Login";

class App extends Component{
    render() {
        return (
            <Router>
                <Switch>
                    <Route path={'/'} exact={true} component={Home}/>
                    <Route path={'/users'} exact={true} component={UserList}/>
                    <Route path={'/users/:id'} component={UserEdit}/>
                    <Route path={'/login'} component={Login}/>
                </Switch>
            </Router>
        )
    }
}

export default App;
