import React from 'react';


import 'bootstrap/dist/css/bootstrap.min.css';


//const USERS_REST_API_URL = 'http://jsonplaceholder.typicode.com/users';
const USERS_REST_API_URL = 'http://localhost:8080/users';

class UserList extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount() {
        fetch(USERS_REST_API_URL)
        .then(res => res.json())
        .then((data) => {
          this.setState({ users: data })
        })
        .catch(console.log)


    }


    render () {
        return (
            
            <div className="text-left" >                                         

                                <button className="btn btn-primary btn-sm text-left" id ="defineVF">+ Define a new user</button>               
                <table className = "table table-striped">
                    <thead>
                        <tr>

                            <td> User Id</td>
                            <td> User First Name</td>
                            <td> User Last Name</td>
                            <td> User Email Id</td>
                            <td> Action</td>
                        </tr>

                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user => 
                                <tr key = {user.id}>
                                     <td> {user.id}</td>   
                                     <td> {user.firstName}</td>   
                                     <td> {user.lastName}</td>   
                                     <td> {user.email}</td>  
                                     <td> 
                                     <button className="btn btn-primary btn-sm  btn-lg" >Edit User</button>
                                     <button className="btn btn-danger btn-sm  btn-lg">Remove</button>                                         
                                    </td>                                        
                                </tr>
                            )
                        }

                    </tbody>
                </table>
                </div>

            

        )
    }

}

export default UserList;