import React, {Component} from 'react';
import Title from '../../UIComponents/header/Title.js';
import Slogan from '../../UIComponents/header/Slogan.js';
import NewWallet from '../../UIComponents/modal/NewWallet.js';

class Wallet extends Component {
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
                                <h3>Wallet</h3>
                                <p>Do not forget to also configure all the necessary data for comfortable work:</p>
                                <ul>
                                    <li>add your Wallet,</li>
                                    <li>choose a suitable currency,</li>
                                    <li>set an initial balance.</li>
                                </ul>
                                <NewWallet/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Wallet;