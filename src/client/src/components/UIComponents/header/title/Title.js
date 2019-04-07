import React, {Component} from 'react';

class Title extends Component {
    render() {
        return (
            <div style={titlePosition}>
                <p style={projectTitle}>Budget</p>
            </div>
        )
    }
}

export default Title;

const projectTitle = {
    fontFamily: "Sans-Serif",
    fontSize: "50px",
    textAlign: "left",
    color: "#5f8420"
};

const titlePosition = {
    position: "relative",
};