import React, {Component} from 'react';

class Slogan extends Component {
    render() {
        return (
            <div style={sloganPosition}>
                <p style={projectSlogan}>The best way to keep your budget on track</p>
            </div>
        )
    }
}

export default Slogan;

const projectSlogan = {
    fontFamily: "Sans-Serif",
    fontSize: "25px",
    fontStyle: "italic",
    textAlign: "right",
    color: "#5f8420"
};

const sloganPosition = {
    position: "relative",
    marginTop: "4%"
};