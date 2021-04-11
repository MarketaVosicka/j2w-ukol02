package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;
import java.util.List;
import java.util.Arrays;

/**
 * @author MarketaVosicka
 */

@Controller
public class MainController {

    private final Random random;

    public MainController() {
        random = new Random();
    }

    List <String> quotesList = Arrays.asList("<strong>Debugging</strong> /de·bugh·ing/ <em>verb</em><br/>The Classic Mystery Game where you are the detective, the victim, and the murderer.",
            "A user interface is like a joke. If you have to explain it, it's not that good.",
            "To replace programmers with robots, clients will have to accurately describe what they want. We're safe.",
            "I have a joke on programming but it only works on my computer.",
            "99 little bugs in the code, 99 bugs in the code. Take one down, patch it around. 127 little bugs in the code…",
            "When I wrote this code, only God & I understood what it did. Now… Only God knows.",
            "<strong>Programmer</strong> <em>(noun.)</em>: A machine that turns coffee into code.",
            "Real programmers count from 0.",
            "Software and cathedrals are much the same — first we build them, then we pray.",
            "It’s not a bug — it’s an undocumented feature.",
            "There are 10 kinds of people in the world: Those who know binary and those who don’t.",
            "There’s no place like 127.0.0.1.");

    @GetMapping("/")
    public ModelAndView getRandomQuote() {
        int quoteIndex = random.nextInt(quotesList.size());
        int imageIndex = random.nextInt(11) + 1;
        ModelAndView result = new ModelAndView("quotes");
        String quote = quotesList.get(quoteIndex);
        result.addObject("quote", quote);
        result.addObject("image", String.format("/images/%d.jpeg", imageIndex));
        return result;
    }
}