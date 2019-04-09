const HtmlWebPackPlugin = require('html-webpack-plugin');
const path = require('path');

module.exports = {
    entry: './src/index.js',
    output: {
        filename: 'bundle.js',
        path: path.join(__dirname, 'public')
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                loader: 'babel-loader'
            }, {
                test: /\.html$/,
                loader: 'html-loader'
            }, {
                test: /\.svg|png|jpg$/,
                loader: 'url-loader'
            }, {
                test: /\.s?css$/,
                use: [
                    'style-loader',
                    'css-loader',
                    'sass-loader'
                ]
            }, {
                test: /\.(woff|woff2|eot|ttf|ico)$/,
                loader: 'url-loader?limit=100000',
                options: {
                    name: 'public/fonts/[name].[ext]'
                },
            }
        ]
    },
    devServer: {
        contentBase: path.join(__dirname, 'public'),
        historyApiFallback: true
    },
    plugins: [
        new HtmlWebPackPlugin({
            template: './src/index.html',
            favicon: './src/favicon.ico'
        })
    ]
};