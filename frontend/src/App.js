import "./App.css";
import UserList from "./components/UserList";

import AddNewUser from "./components/AddNewUser";

function App() {
  return (
    <div className="App">
      <h1 className="text-left">Demo </h1>

      <AddNewUser />
      <UserList />
    </div>
  );
}
export default App;
