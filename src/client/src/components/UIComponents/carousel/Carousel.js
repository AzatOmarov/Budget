import React, {Component} from 'react';
import styled from "styled-components";
import carousel1 from '../../../resources/carousel_1.png';
import carousel2 from '../../../resources/carousel_2.png';
import carousel3 from '../../../resources/carousel_3.png';

const Wrapper = styled.div`
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    margin-top:8%;
`;

class Carousel extends Component {
    render() {
        return (
            <Wrapper>
                <div id="carouselExampleControls" className="carousel slide" data-ride="carousel">
                    <div className="carousel-inner">
                        <div className="carousel-item active">
                            <img src={carousel1} className="d-block w-100 rounded" alt="..."/>
                        </div>
                        <div className="carousel-item">
                            <img src={carousel2} className="d-block w-100 rounded" alt="..."/>
                        </div>
                        <div className="carousel-item">
                            <img src={carousel3} className="d-block w-100 rounded" alt="..."/>
                        </div>
                    </div>
                    <a className="carousel-control-prev" href={"#carouselExampleControls"} role="button"
                       data-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"/>
                        <span className="sr-only">Previous</span>
                    </a>
                    <a className="carousel-control-next" href={"#carouselExampleControls"} role="button"
                       data-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"/>
                        <span className="sr-only">Next</span>
                    </a>
                </div>
            </Wrapper>
        )
    }
}

export default Carousel;