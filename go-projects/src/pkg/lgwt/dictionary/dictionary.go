package dictionary

const (
	ErrWordNotFound       = DictionaryErr("word not present")
	ErrWordAlreadyPresent = DictionaryErr("word already present")
)

type DictionaryErr string

func (e DictionaryErr) Error() string {
	return string(e)
}

func (dictionary Dictionary) Search(text string) (string, error) {
	definition, ok := dictionary[text]
	if !ok {
		return "", ErrWordNotFound
	}
	return definition, nil
}

func (dictionary Dictionary) Add(text string, explanation string) (error) {
	_, ok := dictionary[text]
	if ok {
		return ErrWordAlreadyPresent
	}
	dictionary[text] = explanation
	return nil
}

func (dictionary Dictionary) Update(text string, explanation string) (error) {
	_, ok := dictionary[text]
	if !ok {
		return ErrWordNotFound
	}
	dictionary[text] = explanation
	return nil
}

func (dictionary Dictionary) Delete(text string) {
	delete(dictionary, text)
}

type Dictionary map[string]string
