import logo from './logo.svg';
import './App.css';
import LoginPage from './pages/LoginPage'
import MainPage from './pages/MainPage'
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
