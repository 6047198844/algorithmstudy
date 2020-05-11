function solution(S) {
    const brackets = {"(": ")", "{": "}", "[": "]"};
    const open = [];
    let o_top = 0, c_top = 0;
    [...S].forEach(el => {
        Object.keys(brackets).indexOf(el) === -1 ?
            Object.values(brackets)[Object.keys(brackets).indexOf(open[o_top - 1])] === el ? o_top-- : c_top++ :
            open[o_top++] = el;
    });
    return o_top === 0 && c_top === 0 ? 1 : 0;
}
