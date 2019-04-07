import React, {Component} from 'react';
import Title from '../../UIComponents/header/title/Title';
import Slogan from '../../UIComponents/header/slogan/Slogan';

class App extends Component {
    render() {
        return (
            <div className="row">
                <div className="col-5">
                    <Title/>
                </div>
                <div className="col-7">
                    <Slogan/>
                </div>
            </div>
        )
    }
}

export default App;
