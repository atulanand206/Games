package hello

func HelloWorld() string {
	return Hello(world, "")
}

const englishHelloPrefix = "Hello, "
const spanishHelloPrefix = "Hola, "
const frenchHelloPrefix = "Bonjour, "

const spanish = "Spanish"
const french = "French"

const world = "World"
const exclamationSuffix = "!"

func Hello(text string, language string) string {
	if text == "" {
		text = world
	}
	return greetingPrefix(language) + text + exclamationSuffix
}

func greetingPrefix(language string) (prefix string) {
	switch language {
	case french:
		prefix = frenchHelloPrefix
	case spanish:
		prefix = spanishHelloPrefix
	default:
		prefix = englishHelloPrefix
	}
	return
}
