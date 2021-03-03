import "./App.css";
import UserList from "./components/UserList";
import { useState } from "react";
import FormDialog from "./components/FormDialog";

function App() {
  const [counter, setCounter] = useState(-9);
  
  const increment = () => {
    setCounter(counter +1);
    console.log(counter)
  }

  return (
    <div className="App">
      <h1 className="text-left">User List </h1>
      <h2> Counter = {counter} </h2>
      <button onClick={increment}></button>
      <FormDialog />

      <UserList />
    </div>
  );
}
export default App;
