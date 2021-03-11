import React from "react";
import axios from "axios";

const USERS_REST_API_URL = "http://localhost:8086/users";

class UserService extends React.Component {
  getUsers() {
    return axios.get(USERS_REST_API_URL);
  }

  createNewUser(user) {
    return axios.post(USERS_REST_API_URL, user);
  }

  getUserById(userId) {
    return axios.get(USERS_REST_API_URL + "/" + userId);
  }

  updateUser(userId, user) {
    return axios.put(USERS_REST_API_URL + "/" + userId, user);
  }

  deleteUser(userId) {
    return axios.delete(USERS_REST_API_URL + "/" + userId);
  }
}
export default new UserService();
