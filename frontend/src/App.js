import './App.css';
import UserList from './components/UserList';
import CreateUser from './components/CreateUser';
function App() {
  return (
      <div className="App">
        <h1 className="text-left">User List</h1>

        <UserList/>
      </div>      

  );
}

export default App;
