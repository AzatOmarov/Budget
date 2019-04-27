import React, {Component} from 'react';
import styled from 'styled-components';

const Wrapper = styled.div`
    position: relative;
    margin-top: -20px;
`;

const Text = styled.p`
    font-size: 50px;
    text-align: left;
    color: #5f8420;
    margin-left: -4px;
`;

class Title extends Component {
    render() {
        return (
            <Wrapper>
                <Text>Budget</Text>
            </Wrapper>
        )
    }
}

export default Title;