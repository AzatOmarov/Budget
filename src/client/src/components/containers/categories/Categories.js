import React, {Component} from 'react';
import Title from '../../UIComponents/header/Title.js';
import Slogan from '../../UIComponents/header/Slogan.js';

class Categories extends Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-5">
                        <p/>
                        <Title/>
                    </div>
                    <div className="col-7">
                        <Slogan/>
                    </div>
                </div>
                <div className="frame-big">
                    <div className="row">
                        <div className="col-12">
                            <div className="main-block">
                                <h3>Categories</h3>
                                <p>See lists of proposed spending and income categories.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Categories;