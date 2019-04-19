import React, {Component} from 'react';
import Title from '../../UIComponents/header/title/Title.js';
import Slogan from '../../UIComponents/header/slogan/Slogan.js';

class Settings extends Component {
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
                </div>
                <div className="frame-big">
                    <div className="row">
                        <div className="col-2"/>
                        <div className="col-8">
                            <h2>Settings</h2>
                            <p>Hi, {this.props.userId}</p>
                        </div>
                        <div className="col-2"/>
                    </div>
                </div>
            </div>
        )
    }
}

export default Settings;