import React from "react";

import "bootstrap/dist/css/bootstrap.min.css";

import UserLine from "./UserLine";
import UserService from "../service/UserService";

class UserList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      users: [],
    };
  }

  componentDidMount() {
    UserService.getUsers().then((response) => {
      this.setState({ users: response.data });
    });

    // fetch(USERS_REST_API_URL)
    //  .then((response) => response.json())
    // .then((data) => {
    //   this.setState({ users: data });
    //})
    // .catch(console.log);
  }

  render() {
    const { users } = this.state;
    console.log(users);
    return (
      <div className="text-left">
        <table className="table table-striped">
          <thead>
            <tr>
              <td>First Name</td>
              <td>Last Name</td>
              <td>Email</td>
              <td>Action</td>
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
