// type definitions for Cypress object "cy"
/// <reference types="cypress" />


describe('Create meme', function() {

    it('Create meme', function() {
        const memeMakerUrl = 'https://imgflip.com/memegenerator';

        const firstInputText = 'Sleep all Saturday';
        const secondInputText = 'Go to DEVBRIDGE hackaton';

        cy.visit(memeMakerUrl); 

        cy.get('div[id="mm-select-popular"]').should('be.visible').within(() => {
            cy.get('div[data-key="0"]').click();

        })
        cy.get('textarea[placeholder="Text #1"]').should('be.visible').type(firstInputText);
        cy.get('textarea[placeholder="Text #2"]').should('be.visible').type(secondInputText);
        cy.get('.mm-generate').should('be.visible').click();

        cy.get(':nth-child(1) > .img-code').should('be.visible').then($value => {
            const link = $value.val();
            const id = link.replace('https://imgflip.com/i/', '');
            const imgUrl = 'https://i.imgflip.com/' + id + '.jpg';

            cy.task("setTempVariable",{name: "memeUrl", value: imgUrl});
        })
    });

    it('Send meme to slack', function() {
        const SLACK_POST_MESSAGE_URL = 'https://slack.com/api/chat.postMessage';
        const SLACK_API_KEY = 'xoxb-2666310489623-2674300956774-JYESWMRAEdiWnNq8WEvFKBzW';
        const SLACK_CHANNEL_ID = 'C02M19K5CTG';
        const METHOD = 'POST';

        cy.task("getTempVariable", "memeUrl").then(memeUrl => {
            cy.log(memeUrl);

            cy.request({
                method: METHOD,
                url: SLACK_POST_MESSAGE_URL,
                headers: {
                    'Content-Type': 'application/json; charset=utf-8',
                    'Authorization' : 'Bearer ' + SLACK_API_KEY
                },
                body: {
                    channel: SLACK_CHANNEL_ID,
                    text: memeUrl
                }
            }).then((response) => {
                cy.log(response);
            })
        });
    })
});