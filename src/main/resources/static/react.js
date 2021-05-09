ReactDOM.render(
    <h1>Hello, world!</h1>,
    document.getElementById('root')
);

class App extends Component {
    state = {
        gender: ""
    };

    handleChange = (e) => {
        this.setState({
            gender: e.target.value
        })
    }

    render() {
        return (
            <div>
                <form>
                    <input type="radio" value="male" id="male"
                           onChange={this.handleChange} name="gender"/> <label for="male">Male</label>

                    <input type="radio" value="female" id="female"
                           onChange={this.handleChange} name="gender"/> <label for="female">Female</label>
                </form>

                <p>You gender is --> {this.state.gender}</p></div>
        );
    }
}