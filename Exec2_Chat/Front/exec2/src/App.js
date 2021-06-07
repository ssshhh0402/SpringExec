import logo from './logo.svg';
import './App.css';
import LoginPage from './container/Auth/LoginPage'
import MainPage from './container/Main/MainPage'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
function App() {
  return (
    <>
      <Router>
        <Switch>
          <Route path="/main" component = {MainPage}/>
          <Route path="/" component = {LoginPage}/>
        </Switch>
      </Router>
    </>
  );
}

export default App;
