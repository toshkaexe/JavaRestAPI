import React from "react";

import "bootstrap/dist/css/bootstrap.min.css";

import UserLine from "./UserLine";

//const USERS_REST_API_URL = 'http://jsonplaceholder.typicode.com/users';
const USERS_REST_API_URL = "http://localhost:8085/users";

class UserList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      users: [],
    };
  }

  componentDidMount() {
    fetch(USERS_REST_API_URL)
      .then((res) => res.json())
      .then((data) => {
        this.setState({ users: data });
      })
      .catch(console.log);
  }

  render() {
    return (
      <div className="text-left">
        <table className="table table-striped">
          <thead>
            <tr>
            
              <td> User First Name</td>
              <td> User Last Name</td>
              <td> User Email Id</td>
              <td> Action</td>
            </tr>
          </thead>
          <tbody>
            {this.state.users.map((user) => (
              <UserLine
                id={user.id}
                firstname={user.firstName}
                lastname={user.lastName}
                email={user.email}
              />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default UserList;
