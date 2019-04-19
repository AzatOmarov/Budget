import React, {Component} from 'react';
import Title from '../../UIComponents/header/title/Title.js';
import Slogan from '../../UIComponents/header/slogan/Slogan.js';
import Carousel from '../../UIComponents/carousel/Carousel.js';

class App extends Component {
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