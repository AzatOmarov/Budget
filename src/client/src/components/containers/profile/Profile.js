import React, {Component} from 'react';
import Title from '../../UIComponents/header/title/Title.js';
import Slogan from '../../UIComponents/header/slogan/Slogan.js';
import NameInput from '../../UIComponents/profileComponents/NameInput';
import EmailInput from '../../UIComponents/profileComponents/EmailInput';
import OldPassword from '../../UIComponents/profileComponents/OldPassword';
import NewPassword from '../../UIComponents/profileComponents/NewPassword';
import CancelSave from '../../UIComponents/button/CancelSave';
import TSPButtonGroup from '../../UIComponents/button/TSPButtonGroup';

class Profile extends React.Component {
    constructor(){
        super()
        this.state={
            name : "",
            email: "",
            password: ""
        }
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-5">
                        <Title/>
                    </div>
                    <div className="col-7">
                        <Slogan/>
                    </div>
                    <TSPButtonGroup/>
                </div>
                <div className="frame-big">
                    <NameInput/>
                    <EmailInput/>
                    <OldPassword/>
                    <NewPassword/>
                    <CancelSave/>
                </div>

            </div>
        )
    }
}

export default Profile;