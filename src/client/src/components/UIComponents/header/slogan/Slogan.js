import React, {Component} from 'react';
import styled from 'styled-components';

const Wrapper = styled.div`
    position: relative;
    margin-top: 1%;
`;

const Text = styled.p`
    font-size: 25px;
    font-style: italic;
    text-align: right;
    color: #080808;
`;

class Slogan extends Component {
    render() {
        return (
            <Wrapper>
                <Text>The best way to keep your budget on track</Text>
            </Wrapper>
        )
    }
}

export default Slogan;