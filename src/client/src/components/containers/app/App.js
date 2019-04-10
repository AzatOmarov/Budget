import React, {Component} from 'react';
import Title from '../../UIComponents/header/title/Title';
import Slogan from '../../UIComponents/header/slogan/Slogan';
import Carousel from '../../UIComponents/carousel/Carousel';
import Login from '../../UIComponents/modal/Login';

class App extends Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-5"/>
                    <div className="col-7">
                        <Login/>
                    </div>
                </div>
                <div className="row">
                    <div className="col-5">
                        <Title/>
                    </div>
                    <div className="col-7">
                        <Slogan/>
                    </div>
                </div>
                <div className="frame-div">
                    <div className="row">
                        <div className="col-2"/>
                        <div className="col-8">
                            <Carousel/>
                        </div>
                        <div className="col-2"/>
                    </div>
                </div>
            </div>
        )
    }
}

export default App;