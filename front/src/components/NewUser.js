import React from 'react';


import 'bootstrap/dist/css/bootstrap.min.css';



class NewUser extends React.Component {

    render () {


        let dialog =(
            <div>  
                <button onClick={this.props.onClick}>Create User</button>
                I am a dialog 
                <div>{this.props.children} </div>

            </div>            
        );
        if(!  this.props.isOpen) {dialog = null;}
        return (
            
            <div>   444                                      
                {dialog}
            </div>

            

        )
    }

}

export default NewUser;